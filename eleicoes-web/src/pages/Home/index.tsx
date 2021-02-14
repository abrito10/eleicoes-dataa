import React from 'react';
import { useAuth } from '../../contexts/auth';
import HomeList from './HomeList';
import './style.css';

const Home: React.FC = () => {
  const { signed, Logout } = useAuth();

  console.log(signed);

  async function handleLogout() {
    Logout();
  }

  return (
    <>
      <div className="home-container">
        <div className="home-content">
          <HomeList />
        </div>
      </div>
      <div>
        <button className="home-btn-logout" onClick={handleLogout}>Sair</button>
      </div>
    </>
  );
};

export default Home;
