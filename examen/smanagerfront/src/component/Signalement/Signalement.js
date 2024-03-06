import React, { useState, useEffect } from 'react';
import './signalement.css';


function Signalement() {
  // État local pour stocker les valeurs du formulaire
  const [formData, setFormData] = useState({
    type: '',
    description: '',
    localisation: '',
    dateDeSoumission: new Date().toISOString().split('T')[0],
    nom: '',
    email: '',
    telephone: ''
  });
  useEffect(() => {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition((position) => {
        const coords = `Lat: ${position.coords.latitude}, Lon: ${position.coords.longitude}`;
        setFormData(prevFormData => ({
          ...prevFormData,
          localisation: coords 
        }));
      }, (error) => {
        console.error("Erreur de géolocalisation", error);
      });
    } else {
      console.log("La géolocalisation n'est pas prise en charge par ce navigateur.");
    }
  }, []);
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(formData);
    alert('Signalement ajouté avec succès!');
  };

  return (
    <form onSubmit={handleSubmit} className="signalement-form">
      <h2>Ajouter un Signalement</h2>
      <div>
        <h3>Incident et Demande</h3>
        <select
            name="type"
            value={formData.typeIncident}
            onChange={handleChange}
            required
            >
            <option value="">Sélectionner un type</option>
            <option value="Demande">Demande</option>
            <option value="Incident">Incident</option>
        </select>
        <textarea
          name="description"
          value={formData.description}
          onChange={handleChange}
          placeholder="Description de l'incident"
          required
        />
        <input 
            type="text" 
            name="localisation" 
            value={formData.localisation}
            onChange={handleChange} 
            placeholder="Localisation" 
            required 
        />

        <input 
            type="date" 
            name="dateDeSoumission" 
            value={formData.dateDeSoumission} // Correction ici
            onChange={handleChange} 
            readOnly 
            required 
        />

      </div>
      <div>
        <h3>Informations Personnelles</h3>
        <input
          type="text"
          name="nom"
          value={formData.nom}
          onChange={handleChange}
          placeholder="Votre nom"
          required
        />
        <input
          type="text"
          name="prenom"
          value={formData.nom}
          onChange={handleChange}
          placeholder="Votre prenom"
          required
        />
        <input
          type="email"
          name="email"
          value={formData.email}
          onChange={handleChange}
          placeholder="Votre email"
          required
        />
        <input
          type="tel"
          name="telephone"
          value={formData.telephone}
          onChange={handleChange}
          placeholder="Votre téléphone"
          required
        />
        <input 
            type="text" 
            name="adresse" 
            value={formData.adresse} // Correction ici
            onChange={handleChange} 
            placeholder="Adresse" 
        />
      </div>
      <button type="submit">Envoyer le Signalement</button>
    </form>
  );
}

export default Signalement;
