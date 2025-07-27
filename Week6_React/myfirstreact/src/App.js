import React, { useState } from "react";
import trainersMock from "./trainersmock";

function App() {
  const [show, setShow] = useState(false);

  // Show only the first trainer in the detailed view
  const trainer = trainersMock[0];

  return (
    <div style={{ margin: 20, fontFamily: "Tahoma, Arial, sans-serif" }}>
      <h1>My Academy Trainers App</h1>
      <nav>
        <a href="#" style={{ marginRight: 10 }} onClick={() => setShow(false)}>Home</a>
        <a href="#" onClick={() => setShow(true)}>Show Trainers</a>
      </nav>
      {show && (
        <div style={{ marginTop: 20 }}>
          <h2>Trainers Details</h2>
          <div>
            <h3>
              {trainer.name} ({trainer.technology})
            </h3>
            <p>{trainer.email}</p>
            <p>{trainer.phone}</p>
            <ul>
              {trainer.skills.map((skill, i) => (
                <li key={i}>{skill}</li>
              ))}
            </ul>
          </div>
        </div>
      )}
    </div>
  );
}

export default App;
