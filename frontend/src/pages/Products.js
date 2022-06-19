import React, { Component } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

class Products extends Component {
    constructor(props) {
        super(props);
        this.state = {
            products: [],
            error: false,
            errorMessage: ""
        };
        document.title = "Products";
    }
    componentDidMount() {
        this.getProducts();
    }

    getProducts() {
        axios.get(process.env.REACT_APP_API_URL + "/products")
            .then((response) => {
                this.setState({ products: response.data.data });
                this.setState({ error: false, errorMessage: "" });
            })
            .catch((error) => {
                document.title = error.response.data.data;
                this.setState({ error: true, errorMessage: error.response.data.data });
            });
    }

    render() {
        return (
            <div>
                <h1>Products</h1>
                {this.state.products.map((product) => {
                    return (
                        <div key={product.ID} className="card mb-3">
                            <div className="card-body">
                                <h5 className="card-title">{product.title}</h5>
                                <p className="card-text">{product.short_description}</p>
                                <Link to={"/" + product.url_alias} className="btn btn-primary">Find Out More</Link>
                            </div>
                        </div>
                    );
                })}
            </div>
        );
    }
}

// eslint-disable-next-line
export default Products;