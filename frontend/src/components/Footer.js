import React from "react";

const Footer = () => {
    return (
        <footer className="footer mt-auto py-3 bg-light fixed-bottom">
            <div className="container">
                <span className="text-muted">
                    ©{(new Date()).getFullYear()}. All Rights Reserved at My Blog
                </span>
            </div>
        </footer>
    );
}

export default Footer;