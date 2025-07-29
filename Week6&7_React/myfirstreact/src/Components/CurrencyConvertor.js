import React, { Component } from "react";

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      amount: "",
      currency: "",
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  handleSubmit(e) {
    e.preventDefault();
    // Conversion logic: 1 Euro = 80 INR (example conversion)
    const { amount, currency } = this.state;
    if (!amount || !currency) {
      alert("Please enter the amount and currency.");
      return;
    }
    if (currency.toLowerCase() === "euro") {
      // 1 Euro = 80 INR -> INR to Euro
      let converted = Number(amount) * 80;
      alert(`Converting to Euro Amount is ${converted}`);
    } else {
      alert("Currency not supported. Please enter 'Euro'.");
    }
  }

  render() {
    return (
      <div style={{ marginTop: 40 }}>
        <h1 style={{ color: "green", fontWeight: "bold" }}>
          Currency Convertor!!!
        </h1>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label htmlFor="amount">Amount:</label>
            <input
              type="number"
              style={{ marginLeft: 10, marginBottom: 10 }}
              id="amount"
              name="amount"
              value={this.state.amount}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label htmlFor="currency">Currency:</label>
            <textarea
              id="currency"
              name="currency"
              value={this.state.currency}
              style={{ marginLeft: 10, marginBottom: 10 }}
              onChange={this.handleChange}
            />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default CurrencyConvertor;
