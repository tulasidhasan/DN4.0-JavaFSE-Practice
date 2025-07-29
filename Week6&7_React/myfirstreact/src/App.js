import React, { useState } from 'react';
import Home from './Components/Home';
import About from './Components/About';
import Contact from './Components/Contact';
import { CalculateScore } from './Components/CalculateScore';
import Posts from './Posts';
import CohortDetails from './Components/CohortDetails';
import ListOfPlayers from './Components/ListOfPlayers';
import IndianPlayers from './Components/IndianPlayers';
import OfficeSpaceApp from './Components/OfficeSpaceApp';
import EventHandlingApp from './Components/EventHandlingApp';
import TicketBookingApp from './Components/TicketBookingApp';
import BloggerApp from './Components/BloggerApp';


import './App.css'


function App() {
  const [selectedApp, setSelectedApp] = useState('');
  const [flag, setFlag] = useState(true);
   const toggleFlag = () => {
    setFlag(prev => !prev);
  };

  return (
    <div className="App" style={{ padding: '20px', fontFamily: 'sans-serif' }}>
      <h1>📦 Multi-App Launcher</h1>
      
      <select onChange={(e) => setSelectedApp(e.target.value)} value={selectedApp}>
        <option value="">-- Select an App --</option>
        <option value="home">Home/About/Contact</option>
        <option value="score">Score Calculator</option>
        <option value="lifecycle">Lifecycle Demo</option>
        <option value="cohort">Cohort Details</option>
        <option value="cricket">Cricket App</option>
        <option value="office">OfficeSpaceApp</option>
        <option value="events">Event Handling + Currency Converter</option>
        <option value="ticket">Ticket Booking App</option>
        <option value="blogger">Blogger App</option>

        

      </select>

      <hr />

      {selectedApp === 'home' && (
        <>
          <Home />
          <About />
          <Contact />
        </>
      )}

      {selectedApp === 'score' && (
        <CalculateScore
          Name="Steeve"
          School="DNV Public School"
          total={284}
          goal={3}
        />
      )}

      {selectedApp === 'lifecycle' && <Posts />}

      {selectedApp === 'cohort' && <CohortDetails />}

      {selectedApp === 'cricket' && (
         <>
            <h2>CricketApp</h2>
            <button onClick={toggleFlag}>
              {flag ? "Show IndianPlayers" : "Show ListOfPlayers"}
            </button>
            {
              flag ? (
                <ListOfPlayers />
              ) : (
                <IndianPlayers />
              )
            }
          </>
      )}

      {selectedApp === 'office' && <OfficeSpaceApp/>}

      {selectedApp === 'events' && <EventHandlingApp />}

      {selectedApp === 'ticket' && <TicketBookingApp />}
      
      {selectedApp === 'blogger' && <BloggerApp />}

      {!selectedApp && <p>👆 Please select an app to preview it here.</p>}
    </div>
  );
}

export default App;
