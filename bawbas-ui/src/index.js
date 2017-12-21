import React, {Component} from "react";
import ReactDOM from "react-dom";
import App, {NewInstituition, InstitutionDetail} from "./App";
import { Router, Route, IndexRoute, hashHistory } from "react-router";
import "./index.css";
import PropTypes from "prop-types";

var InitialApp = props => {
  return(
    <div className="container">
    <AppVariables />
    {props.children}
    </div>
  );
};

class AppVariables extends Component {
  static childContextTypes = {
    router: PropTypes.object
  };
  getChildContext() {
    return {
      router: this.props.router
    };
  }
  render() {
    return null;
  }
}

var NoMatch = props => {
  return <div className="container">Route did not match</div>;
};

ReactDOM.render(
  <Router history={hashHistory}>
    <Route path="/" component={InitialApp}>
      <IndexRoute component={App} />
      <Route path="/:institutionId" component={InstitutionDetail} />
      <Route path="/new" component={NewInstituition} />
      <Route path="*" component={NoMatch} />
    </Route>
  </Router>,
  document.getElementById("root")
);
