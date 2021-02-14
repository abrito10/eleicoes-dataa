import React from 'react';
import { useAuth } from '../../contexts/auth';
import './style.css';

const Login: React.FC = () => {
  const { signed, Login } = useAuth();

  console.log(signed);

  async function handleLogin() {
    await Login({
    email: 'abrito10@gmail.com',
      password: '123456',
    });
    }

  return (
    <>
      <div className="login-container">
        <div className="login-content">
          <div>
            <h1>Login Mock</h1>
            
            <h6>Usuario: abrito10@gmail.com</h6>
            <h6>Password: *****</h6>
            <button className="login-summary-make-login" onClick={handleLogin}>Login</button>
          </div>
        </div>
      </div>
    </>
  );
};

export default Login;