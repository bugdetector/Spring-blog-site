import React, { Component } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import Error from "../components/Error";

class Page extends Component {
    constructor(props) {
        super(props);
        this.state = {
            page: {
                title: "",
                body: ""
            },
            error: false,
            errorMessage: ""
        };
    }
    componentDidMount() {
        this.updatePage();
    }

    componentDidUpdate(prevProps) {
        if (prevProps.params.url_alias !== this.props.params.url_alias) {
            this.updatePage();
        }
    }

    updatePage() {
        axios.get(process.env.REACT_APP_API_URL + "/page/" + this.props.params.url_alias)
            .then((response) => {
                this.setState({ page: response.data });
                document.title = this.state.page.title;
                this.setState({ error: false, errorMessage: "" });
            })
            .catch((error) => {
                document.title = error.response.data.data;
                this.setState({ error: true, errorMessage: error.response.data.data });
            });
    }

    render() {
        if (this.state.error) {
            return <Error errorMessage={this.state.errorMessage} />
        } else {
            return (
                <div>
                    <h1>{this.state.page.title}</h1>
                    <p dangerouslySetInnerHTML={{ __html: this.state.page.body ? this.state.page.body : this.state.page.description }}></p>
                </div>
            );
        }
    }
}

// eslint-disable-next-line
export default (props) => (
    <Page
        {...props}
        params={useParams()}
    />
);;