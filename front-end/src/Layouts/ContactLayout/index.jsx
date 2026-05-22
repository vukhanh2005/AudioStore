import Banner from "../../components/Banner";
import TopMenu from "../../components/TopMenu";

function ContactLayout({children}) {
    return ( 
        <div>
            <Banner/>
            <div className="contact-content">
                <TopMenu/>
                {children}
            </div>
        </div>
     );
}

export default ContactLayout;