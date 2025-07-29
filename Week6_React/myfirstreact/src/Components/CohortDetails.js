// CohortDetails.js
import React from "react";
import styles from "../Stylesheets/CohortDetails.module.css";

// COLOR-FUNCTION: Must use inline style for h3 as per requirements.
const getStatusColor = (status) => ({
  color: status.toLowerCase() === "ongoing" ? "green" : "blue"
});

// A sample single cohort component:
const CohortBox = ({ cohort }) => (
  <div className={styles.box}>
    <h3 style={getStatusColor(cohort.status)}>
      {cohort.name}
    </h3>
    <dl>
      <dt>Started On</dt>
      <dd>{cohort.startedOn}</dd>
      <dt>Current Status</dt>
      <dd>{cohort.status}</dd>
      <dt>Coach</dt>
      <dd>{cohort.coach}</dd>
      <dt>Trainer</dt>
      <dd>{cohort.trainer}</dd>
    </dl>
  </div>
);

// Example usage in dashboard:
const cohorts = [
  {
    name: "INTADMDF10 -.NET FSD",
    startedOn: "22-Feb-2022",
    status: "Scheduled",
    coach: "Aathma",
    trainer: "Jojo Jose"
  },
  {
    name: "ADM21JF014 - Java FSD",
    startedOn: "10-Sep-2021",
    status: "Ongoing",
    coach: "Apoorv",
    trainer: "Elisa Smith"
  },
  {
    name: "CDBJF21025 - Java FSD",
    startedOn: "24-Dec-2021",
    status: "Ongoing",
    coach: "Aathma",
    trainer: "John Doe"
  }
];

const CohortDetails = () => (
  <div>
    <h2>Cohorts Details</h2>
    {cohorts.map((c, idx) => (
      <CohortBox cohort={c} key={idx} />
    ))}
  </div>
);

export default CohortDetails;
