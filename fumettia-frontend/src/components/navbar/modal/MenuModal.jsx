import React from 'react';
import "../../../styles/ModalAccesso.css";
import BodyLogout from './BodyLogout';
import BodyAccesso from './BodyAccesso';
import { useSelector } from 'react-redux';

function MenuModal({ onClose }) {
    const userInfo = useSelector((state) => state.utente);

    return (
        <div className='modalOverlay'>
            <div className='modalContent'>
                <div className='modalHeader'>
                    <h2 className='menuTitle'>Menù</h2>
                    <button className='closeButton' onClick={onClose}>
                        X
                    </button>
                </div>
                <div className='modalBody'>
                    <div className='centerButtons'>
                        {Object.keys(userInfo).length > 0 ? (
                            <BodyLogout />
                        ) : (
                            <BodyAccesso />
                        )}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default MenuModal;
