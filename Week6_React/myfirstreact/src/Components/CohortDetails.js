// src/components/CohortDetails.js
import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails({ cohort }) {
  const { name, startedOn, status, coach, trainer } = cohort;

  // inline style for h3 based on status
  const titleStyle = {
    color: status.toLowerCase() === 'ongoing' ? 'green' : 'blue'
  };

  return (
    <div className={styles.box}>
      <h3 style={titleStyle}>{name}</h3>
      <dl>
        <dt>Started On</dt>
        <dd>{startedOn}</dd>
        <dt>Current Status</dt>
        <dd>{status}</dd>
        <dt>Coach</dt>
        <dd>{coach}</dd>
        <dt>Trainer</dt>
        <dd>{trainer}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
