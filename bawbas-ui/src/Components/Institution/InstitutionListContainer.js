import React, { Component } from "react";
import InstitutionRow from "./InstitutionRow";
import axios from "axios";
import PropTypes from "prop-types";

export default class InstitutionListContainer extends Component {
  constructor(context) {
    super(context);
    this.state = { institutions: [] };
  }
  componentDidMount() {
    axios
      .get("http://localhost:8080/api/")
      .then(response => {
        this.setState({ institutions: response.data });
      })
      .catch(error => {
        console.log(error);
      });
  }
  handleAddButtonClick = e => {
    this.context.router.push("/new/");
  };

  handleLinkClick = e => {
    let id;
    e.target.nodeName === "A"
      ? (id = e.target.id)
      : (id = e.target.parentElement.id);
    this.context.router.push("/" + id);
  };

  render() {
    const list = this.state.institutions.map((el, index) => (
      <InstitutionRow
        key={index}
        id={el.id}
        imageUrl={el.image}
        name={el.name}
        city={el.city}
        type={el.type}
        books={el.books.length}
        onLinkClick={this.handleLinkClick}
      />
    ));
    return (
      <div className="row">
        <button
          className="btn btn-primary"
          style={{ margin: 20, padding: 10 }}
          onClick={this.handleAddButtonClick}
        >
          Add new institution
        </button>
        <div className="list-group">
          <span className="list-group-item active" style={{ padding: 20 }}>
            <span style={{ paddingLeft: 10 }}> Id </span>
            <span style={{ paddingLeft: 30 }}>Image</span>
            <span style={{ paddingLeft: 40 }}>Name</span>
            <span style={{ paddingLeft: 200 }}>City</span>
            <span style={{ paddingLeft: 50 }}>Type</span>
            <span style={{ float: "right" }}>Books total</span>
          </span>
          {list}
        </div>
      </div>
    );
  }
}
InstitutionListContainer.contextTypes = {
  router: PropTypes.object
}