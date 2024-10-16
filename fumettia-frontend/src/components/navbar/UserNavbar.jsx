import React, { useState, useEffect } from 'react';
import MenuModal from './modal/MenuModal';
import SitoImage from '../../assets/CronoNerdImage.webp';
import LogoSito from '../../assets/logoSito.png';
import { useHistory } from 'react-router-dom';
import { HOMEPAGE } from '../../utility/Rotte';
import "../../styles/SwitchButtonStyle.css";
import { useDispatch, useSelector } from 'react-redux';
import { toggleTheme } from '../../store/slice/themeSlice';
import ThemeSwitcher from '../../utility/ThemeSwitcher';

function UserNavbar() {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const history = useHistory();
  const modePage = useSelector((state) => state.theme.mode);
  const dispatch = useDispatch();

  const toggleModal = () => {
    setIsModalOpen(!isModalOpen);
  };

  const goHomepage = () => {
    history.push(HOMEPAGE);
  };

  const handleThemeToggle = () => {
    dispatch(toggleTheme())
  };

  useEffect(() => {
    if (isModalOpen) {
      document.body.style.overflow = 'hidden';
    } else {
      document.body.style.overflow = 'auto';
    }
  }, [isModalOpen]);

  return (
    <nav
      className={modePage === 'dark' ?
        "navbar navbar-dark bg-dark" :
        "navbar navbar-light"}
      style={{
        backgroundColor: modePage === 'light' ? "#e3e3e3" : undefined
      }}>
      <div style={{ display: 'flex', alignItems: 'center', gap: '16px' }}>
        <img
          src={LogoSito}
          alt="Logo"
          style={{
            border: '0px',
            WebkitMaskImage: 'linear-gradient(180deg, rgba(0, 0, 0, 1) 70%, rgba(0, 0, 0, 0) 100%)',
            maskImage: 'linear-gradient(180deg, rgba(0, 0, 0, 1) 70%, rgba(0, 0, 0, 0) 100%)',
          }}
          onClick={goHomepage}
        />
        <ThemeSwitcher modePage={modePage} handleThemeToggle={handleThemeToggle} />
      </div>

      <img
        src={SitoImage}
        alt="Sito"
        style={{
          width: '302px',
          height: '152px',
          marginRight: '100px'
        }}
      />

      <button
        className={modePage === 'dark' ? "btn dark-btn-custom" : "btn light-btn-custom"}
        onClick={toggleModal}>
        &#9776;
      </button>

      {isModalOpen && (
        <MenuModal
          onClose={toggleModal}
        />
      )}
    </nav>
  );
}

export default UserNavbar;
