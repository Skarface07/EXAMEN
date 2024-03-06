import React from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'; // Ajusté pour v6
import HomePage from './component/Home/HomePage'; // Assurez-vous que le chemin est correct
import Signalement from './component/Signalement/Signalement'; 
import LoginPage from './component/Login/login';

function App() {
  return (
    <Router>
      <div>
        <Routes>
          <Route path="/signalement" element={<Signalement />} />
          <Route path="/" element={<HomePage />} />
          <Route path="Login" element={<LoginPage />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
