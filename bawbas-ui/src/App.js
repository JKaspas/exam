import React, { Component } from "react";
import InstitutionListContainer from "./Components/Institution/InstitutionListContainer";
import InstitutionAdminComponent from "./Components/Institution/InstitutionAdminComponent";
import InstitutionDetailContainer from "./Components/Institution/InstitutionDetailContainer";
import "./App.css";

export class App extends Component {
  render() {
    return (
      <div>
        <InstitutionListContainer />
      </div>
    );
  }
}

export class NewInstitution extends Component {
  render() {
    return (
      <div>
        <InstitutionAdminComponent />
      </div>
    );
  }
}

export class InstitutionDetail extends Component {
  render() {
    return (
      <div>
        <InstitutionDetailContainer />
      </div>
    );
  }
}

export default App;
