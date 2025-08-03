
import React, { useState } from "react";

function LoginButton({ onClick }) {
  return <button onClick={onClick}>Login</button>;
}

function LogoutButton({ onClick }) {
  return <button onClick={onClick}>Logout</button>;
}

function UserGreeting() {
  return (
    <div>
      <h2>Welcome, User!</h2>
      <p>You can now book your tickets.</p>
      <button>Book Ticket</button>
    </div>
  );
}

function GuestGreeting() {
  return (
    <div>
      <h2>Welcome, Guest!</h2>
      <p>Please view available flights. Login to book tickets.</p>
    </div>
  );
}


function TicketBookingApp() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <div style={{ fontFamily: "Arial", margin: 30 }}>
      <h1>✈️ Ticket Booking App</h1>
      {isLoggedIn ? (
        <LogoutButton onClick={() => setIsLoggedIn(false)} />
      ) : (
        <LoginButton onClick={() => setIsLoggedIn(true)} />
      )}
      <hr style={{ margin: 20 }} />
      {isLoggedIn ? <UserGreeting /> : <GuestGreeting />}
    </div>
  );
}

export default TicketBookingApp;
