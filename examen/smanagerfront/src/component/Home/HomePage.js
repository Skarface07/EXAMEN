import React from 'react';
import './HomePage.css'; 
import { useNavigate } from 'react-router-dom';


function HomePage() {

    const navigate = useNavigate();
  return (
    <div className="home-container">
      <header className="home-header">
        <h1>Bienvenue sur notre Plateforme de Signalement</h1>
      </header>
      <section className="home-content">
        <p>
          Notre plateforme offre un moyen rapide et efficace pour signaler des incidents
          dans votre communauté. Que ce soit des problèmes de voirie, des nuisances sonores,
          ou tout autre incident, votre signalement nous aide à améliorer la qualité de vie
          dans votre environnement direct.
        </p>
        <p>
          Vous pouvez suivre en temps réel l'évolution de votre signalement et recevoir des
          notifications à chaque étape du processus. Ensemble, œuvrons pour une communauté plus
          sûre et plus agréable.
        </p>
        <div className="home-actions">
          <button onClick={() => navigate('/Signalement')}>
            Ajouter un signalement
          </button>
          <button onClick={() => { alert("Naviguer vers la page pour voir l'état d'un signalement."); }}>
            Voir l'état de son signalement
          </button>
        </div>
      </section>
    </div>
  );
}

export default HomePage;
