package com.nvk.apicrud.Services;

import com.nvk.apicrud.DTO.Account.AccountResponse;
import com.nvk.apicrud.DTO.Order.OrderResponse;
import com.nvk.apicrud.Entity.Order;
import com.nvk.apicrud.Entity.Product;
import com.nvk.apicrud.Repository.OrderRepository;
import com.nvk.apicrud.Repository.ProductRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final AccountService accountService;

    public OrderService(ProductRepository productRepository, OrderRepository orderRepository, AccountService accountService) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.accountService = accountService;
    }

    @Transactional
    public OrderResponse orderProduct(Integer productId, HttpSession session) {
        AccountResponse account = accountService.currentAccount(session);
        validateAccountId(account);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy sản phẩm"));

        if (product.getSoluong() == null || product.getSoluong() <= 0) {
            throw new IllegalArgumentException("Sản phẩm đã hết hàng");
        }

        product.setSoluong(product.getSoluong() - 1);
        productRepository.save(product);

        Order order = new Order();
        order.setAccountId(account.getId());
        order.setUsername(account.getUsername());
        order.setProductId(product.getId());
        order.setProductName(product.getName());
        order.setPrice(product.getPrice());
        order.setQuantity(1);
        order.setStatus("SUCCESS");
        Order savedOrder = orderRepository.save(order);

        return toResponse(savedOrder, "Đặt hàng thành công");
    }

    public List<OrderResponse> getHistory(HttpSession session) {
        AccountResponse account = accountService.currentAccount(session);
        validateAccountId(account);
        return orderRepository.findByAccountIdOrderByCreatedAtDesc(account.getId())
                .stream()
                .map(order -> toResponse(order, ""))
                .toList();
    }

    private void validateAccountId(AccountResponse account) {
        if (account.getId() == null) {
            throw new IllegalArgumentException("Bảng accounts cần có cột account_id. Vui lòng chạy file accounts.sql.");
        }
    }

    private OrderResponse toResponse(Order order, String message) {
        return new OrderResponse(
                order.getId(),
                order.getProductId(),
                order.getProductName(),
                order.getPrice(),
                order.getQuantity(),
                order.getStatus(),
                message,
                order.getCreatedAt()
        );
    }
}
