import { Outlet } from "react-router-dom";
import Banner from "../../components/Banner";
import TopMenu from "../../components/TopMenu";

function HistoryLayout({children}) {
    return ( 
        <div>
            <Banner/>
            <div className="history-content">
                <TopMenu/>
                {children}
            </div>
        </div>
     );
}

export default HistoryLayout;