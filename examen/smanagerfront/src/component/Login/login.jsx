import React, { useState } from 'react';
import './login.css';
import { Link } from 'react-router-dom';


function LoginPage() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = async (e) => {
    e.preventDefault();
    
    console.log('Logging in with:', username, password);
  };

  return (
    <div className="login-container">
      <h1>My<span>Scad</span></h1>
      <div className="login-buttons">
          <ul className='iconCate'>
              <li>
                  <div className="icon-circle"></div>
                  <span>Admin</span>
              </li>
              <li>
                  <div className="icon-circle"></div>
                  <span>Parent</span>
              </li>
              <li>
                  <div className="icon-circle"></div>
                  <span>Professeur</span>
              </li>
              <li>
                  <div className="icon-circle"></div>
                  <span>Elève</span>
              </li>
          </ul>
      </div>


      <form onSubmit={handleLogin}>
        <div>
          <input
      
            placeholder='Username'
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
        </div>
        <div>
          <input
           placeholder='Password'
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>
        <a href="/recover-password">Récupérer mot de passe</a>
        <button type="submit">
          <Link to="/Autre">Login</Link>
        </button>
      </form>
    </div>
  );
}

export default LoginPage;
