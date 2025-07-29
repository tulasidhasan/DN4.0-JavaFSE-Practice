// src/components/ListOfPlayers.js

import React from "react";

const players = [
  { name: 'Virat', score: 99 },
  { name: 'Rohit', score: 72 },
  { name: 'Rahul', score: 55 },
  { name: 'Surya', score: 88 },
  { name: 'Iyer', score: 56 },
  { name: 'Gill', score: 61 },
  { name: 'Pant', score: 83 },
  { name: 'Jadeja', score: 67 },
  { name: 'Hardik', score: 89 },
  { name: 'Bumrah', score: 92 },
  { name: 'Shami', score: 54 },
];

// Using map
const PlayerList = () => (
  <div>
    <h3>List of Players:</h3>
    <ul>
      {players.map((item, idx) => (
        <li key={idx}>Mr. {item.name} <span>{item.score}</span></li>
      ))}
    </ul>
  </div>
);

// Using arrow and filter functions
const Below70 = () => (
  <div>
    <h3>List of Players having Scores Less than 70:</h3>
    <ul>
      {players.filter(player => player.score < 70)
              .map((item, idx) => (
        <li key={idx}>{item.name} ({item.score})</li>
      ))}
    </ul>
  </div>
);

export default function ListOfPlayers() {
  return (
    <div>
      <PlayerList />
      <Below70 />
    </div>
  );
}
