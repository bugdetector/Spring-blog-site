import React, { Component } from "react";
import { Link } from "react-router-dom";

class Error extends Component {

    render() {
        return (
            <div>
                <h1>{this.props.errorMessage}</h1>
                <Link to={"/"} className="btn btn-link">
                    <i className="bi bi-chevron-left"></i>
                    Back to Home
                </Link>
            </div>
        );
    }
}

export default Error;