// src/components/EventHandlingApp.jsx
import React, { Component } from "react";
import CurrencyConvertor from "./CurrencyConvertor"; // Keep this file in the same folder

class EventHandlingApp extends Component {
  constructor(props) {
    super(props);
    this.state = { count: 5 };
    this.increment = this.increment.bind(this);
    this.decrement = this.decrement.bind(this);
    this.sayHello = this.sayHello.bind(this);
    this.handleIncrement = this.handleIncrement.bind(this);
    this.sayWelcome = this.sayWelcome.bind(this);
    this.handleClick = this.handleClick.bind(this);
  }

  increment() {
    this.setState((prev) => ({ count: prev.count + 1 }));
  }

  decrement() {
    this.setState((prev) => ({ count: prev.count - 1 }));
  }

  sayHello(message) {
    alert("Hello Member! " + message);
  }

  handleIncrement() {
    this.increment();
    this.sayHello("This is a static message.");
  }

  sayWelcome(msg) {
    alert(msg);
  }

  handleClick(event) {
    alert("I was clicked");
  }

  render() {
    return (
      <div style={{ margin: 40 }}>
        <h2>👆 Event Handling + Currency Converter</h2>
        <div>
          <div style={{ fontSize: 22, marginBottom: 12 }}>{this.state.count}</div>
          <button onClick={this.handleIncrement}>Increment</button>
          <button onClick={this.decrement}>Decrement</button>
          <button onClick={() => this.sayWelcome("welcome")}>Say welcome</button>
          <button onClick={this.handleClick}>Click on me</button>
        </div>
        <hr />
        <CurrencyConvertor />
      </div>
    );
  }
}

export default EventHandlingApp;
