import React, { useState } from 'react';
import { useGetGeneriQuery } from '../../api/GenereApi';
import { useSelector } from 'react-redux';
import { FaStar, FaGift, FaShoppingCart } from 'react-icons/fa';

function Sidebar({ onShowAll, onSelectGenere }) {
  const { data: generi, isLoading } = useGetGeneriQuery();
  const [showDropdown, setShowDropdown] = useState(false);
  const modePage = useSelector((state) => state.theme.mode);

  if (isLoading) {
    return <div>Caricamento generi...</div>;
  }

  return (
    <div className={modePage === 'dark' ? "dark-sidebar" : "light-sidebar"}>
      <h3>Esplora</h3>
      <ul>
        <li>
          <button onClick={onShowAll} className="menu-button">
            Mostra tutti
          </button>
        </li>
        <li>
          <button
            onClick={() => setShowDropdown(!showDropdown)}
            className="menu-button"
          >
            Mostra per Genere
          </button>
          {showDropdown && (
            <div className="dropdown-content">
              {generi.map((genere) => (
                <button
                  key={genere.id}
                  onClick={() => onSelectGenere(genere.id)}
                  className="dropdown-item"
                >
                  {genere.nome}
                </button>
              ))}
            </div>
          )}
        </li>
        <li>
          <button className="menu-button">
            <FaStar /> Preferiti
          </button>
        </li>
        <li>
          <button className="menu-button">
            <FaGift /> Offerte
          </button>
        </li>
        <li>
          <button className="menu-button">
            <FaShoppingCart /> Preordini
          </button>
        </li>
      </ul>
    </div>
  );
}

export default Sidebar;
