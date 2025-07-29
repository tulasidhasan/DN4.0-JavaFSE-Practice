import React from "react";
import officeImg from "../Images/office.jpeg";

const offices = [
  { Name: "DBS", Rent: 50000, Address: "Chennai" },
  { Name: "Regus", Rent: 72000, Address: "Mumbai" },
  { Name: "Coworks", Rent: 61000, Address: "Bangalore" },
  { Name: "EcoSpace", Rent: 45000, Address: "Hyderabad" }
];

function getRentColor(rent) {
  return {
    color: rent <= 60000 ? "red" : "green",
    fontWeight: "bold"
  };
}

function OfficeSpaceApp() {
  return (
    <div style={{ fontFamily: "Arial", margin: 40 }}>
      <h1>Office Space, at Affordable Range</h1>
      <img
        src={officeImg}
        width="25%"
        height="25%"
        alt="Office Space"
        style={{ margin: 20 }}
      />
      {offices.map((item, idx) => (
        <div key={idx} style={{ marginTop: 25, marginBottom: 25 }}>
          <h2>Name: {item.Name}</h2>
          <h3>
            Rent: <span style={getRentColor(item.Rent)}>Rs. {item.Rent}</span>
          </h3>
          <h3>Address: {item.Address}</h3>
          <hr />
        </div>
      ))}
    </div>
  );
}

export default OfficeSpaceApp;
