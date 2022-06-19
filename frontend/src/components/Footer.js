import React from "react";

const Footer = () => {
    return (
        <footer className="footer mt-auto py-3 bg-light fixed-bottom">
            <div className="container">
                <span className="text-muted">
                    ©{(new Date()).getFullYear()}. All Rights Reserved at FlatShifter |
                    Designed By <i className="bi bi-heart text-danger mx-3"></i>
                    <a href='https://www.ai-websolutions.com/' target={"_blank"} rel="noreferrer">Ai Web Solutions</a>
                </span>
            </div>
        </footer>
    );
}

export default Footer;