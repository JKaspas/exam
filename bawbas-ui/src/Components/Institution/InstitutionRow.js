import React, { Component } from "react";

export default class InstitutionRow extends Component {
  render() {
    return (
      <a id={this.props.id} onClick={this.props.onLinkClick} className="list-group-item">
        <span style={{padding:20}}>{this.props.id}</span>
          <image src={this.props.imageUrl} alt="Institution" style={{ height: 60, paddingLeft:20 }} />
          <span style={{paddingLeft:50}}>{this.props.name}</span>
          <span style={{paddingLeft:150}}>{this.props.city}</span>
          <span style={{paddingLeft:50}}>{this.props.type}</span>
          <span className="badge badge-pill">{this.props.books}</span>
          
      </a>
    );
  }
}
