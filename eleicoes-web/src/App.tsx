import React from 'react';
import './App.css';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

import Routes from './routes';
import { AuthProvider } from './contexts/auth';
import Navbar from './pages/Navbar';

function App() {
  return (
    <>
      <AuthProvider>
      <Navbar/>
        <Routes />
        <ToastContainer/>
      </AuthProvider>
    </>
  );
}

export default App;
