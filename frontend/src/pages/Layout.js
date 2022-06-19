import { Outlet } from "react-router-dom";

import Navbar from "../components/Navbar";
import Footer from "../components/Footer";
const Layout = () => {
    return (
        <>
            <Navbar />
            <main className="flex-shrink-0" style={{ "marginTop" : "60px", marginBottom: "60px" }}>
                <div className="container">
                    <Outlet />
                </div>
            </main>
            <Footer />
        </>
    )
};

export default Layout;