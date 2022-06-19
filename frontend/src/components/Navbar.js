import React, { Component } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

class Navbar extends Component {

    constructor(props) {
        super(props);
        this.state = {
            elements: []
        };
    }

    componentDidMount() {
        axios.get(process.env.REACT_APP_API_URL + "/navbar")
            .then((response) => {
                this.setState({ elements: response.data.data });
            })
            .catch(function (error) {
                //console.log(error);
            });
    }

    render() {
        return (
            <header>
                <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                    <div className="container-fluid">
                        <a className="navbar-brand" href="/">Flat Shifter</a>
                        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                            <span className="navbar-toggler-icon"></span>
                        </button>
                        <div className="collapse navbar-collapse" id="navbarCollapse">
                            <ul className="navbar-nav me-auto mb-2 mb-md-0">
                                {this.state.elements.map((el) => {
                                    if (el.subitems.length === 0) {
                                        return (<li className="nav-item" key={el.ID}>
                                            <Link to={el.url} className="nav-link">{el.title}</Link>
                                        </li>);
                                    } else {
                                        return (
                                        <li className="nav-item dropdown" key={el.ID}>
                                            <Link to={el.url} className="nav-link dropdown-toggle" data-bs-toggle="dropdown">{el.title}</Link>
                                            <ul className="dropdown-menu">
                                                <li key={el.ID}>
                                                        <Link to={el.url} className="dropdown-item">{el.title}</Link>
                                                </li>
                                                {el.subitems.map((subitem) => {
                                                    return (<li key={subitem.ID}>
                                                        <Link to={subitem.url} className="dropdown-item">{subitem.title}</Link>
                                                    </li>);
                                                })}
                                            </ul>
                                        </li>);
                                    }
                                })}
                            </ul>
                            <form className="d-flex" role="search" action="/">
                                <input className="form-control me-2" type="search" name="search" placeholder="Search" aria-label="Search" />
                                <button className="btn btn-outline-success" type="submit">Search</button>
                            </form>
                        </div>
                    </div>
                </nav>
            </header>
        );
    }
}

export default Navbar;