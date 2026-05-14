import Banner from "../../components/Banner";
import LeftMenu from "../../components/LeftMenu";
import TopMenu from "../../components/TopMenu";

function DefaultLayout({children}) {
    return ( 
        <div className="default-layout">
            <Banner/>
            <TopMenu/>
            <div className="default-content-box">
                <LeftMenu/>
                <div className="content">
                    {children}
                </div>
            </div>
        </div>
     );
}

export default DefaultLayout;