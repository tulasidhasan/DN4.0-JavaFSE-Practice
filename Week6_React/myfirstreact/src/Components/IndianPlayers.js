import React from "react";

const T20Players = [
  "Sachin1",
  "Dhoni2",
  "Virat3",
  "Rohit4",
  "Yuvaraj5",
  "Raina6"
];
const RanjiTrophyPlayers = [
  "Dravid7",
  "Kumble8",
  "Zaheer9",
  "Sehwag10"
];

// Merge with ES6 spread operator
const IndianTeam = [...T20Players, ...RanjiTrophyPlayers];

// Destructuring for Odd/Even: Only first 6 are used in screenshot
const [first, second, third, fourth, fifth, sixth] = T20Players;

// Prepare arrays for mapped output
const oddPlayers = [
  { label: "First", value: first },
  { label: "Third", value: third },
  { label: "Fifth", value: fifth }
];

const evenPlayers = [
  { label: "Second", value: second },
  { label: "Fourth", value: fourth },
  { label: "Sixth", value: sixth }
];

export default function IndianPlayers() {
  return (
    <div>
      <h1>Odd Players</h1>
      <ul>
        {oddPlayers.map((player, i) => (
          <li key={i}>
            {player.label} : {player.value}
          </li>
        ))}
      </ul>
      <h1>Even Players</h1>
      <ul>
        {evenPlayers.map((player, i) => (
          <li key={i}>
            {player.label} : {player.value}
          </li>
        ))}
      </ul>
      <h2>List of Indian Players Merged:</h2>
      <ul>
        {IndianTeam.map((name, i) => (
          <li key={i}>Mr. {name} Player</li>
        ))}
      </ul>
    </div>
  );
}
