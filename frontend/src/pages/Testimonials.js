import React, { Component } from "react";
import axios from "axios";

class Testimonials extends Component {
    constructor(props) {
        super(props);
        this.state = {
            testimonials: [],
            error: false,
            errorMessage: ""
        };
        document.title = "Testimonials";
    }
    componentDidMount() {
        this.getProducts();
    }

    getProducts() {
        axios.get(process.env.REACT_APP_API_URL + "/testimonials")
            .then((response) => {
                this.setState({ testimonials: response.data.data });
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
                <h1>Testimonials</h1>
                {this.state.testimonials.map((testimonial) => {
                    return (
                        <div key={testimonial.ID} className="card mb-3">
                            <div className="card-body">
                                <p className="card-text" dangerouslySetInnerHTML={{ __html: testimonial.testimonial }}></p>
                            </div>
                        </div>
                    );
                })}
            </div>
        );
    }
}

// eslint-disable-next-line
export default Testimonials;