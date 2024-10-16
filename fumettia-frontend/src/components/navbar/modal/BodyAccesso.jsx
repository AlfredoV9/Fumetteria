import React, { useState } from 'react';
import ModalButton from './ModalButton';
import { FaCalendarAlt, FaQuestionCircle } from 'react-icons/fa';
import OutlinedButton from './OutlinedButton';
import CustomModal from './CustomModal';

function BodyAccesso() {
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [modalContent, setModalContent] = useState('');

    const handleOpenModal = (content) => {
        setModalContent(content);
        setIsModalOpen(true);
    };

    const handleCloseModal = () => {
        setIsModalOpen(false);
        setModalContent('');
    };

    return (
        <>
            <div className='loginPrompt'>
                <span className='loginText'>Accedi o registrati per salvare le tue operazioni</span>
            </div>
            <div className='buttonGroup'>
                <ModalButton
                    onClick={() => handleOpenModal('ACCESSO')}
                    text="Accedi"
                    style={{ color: '#E1058B', backgroundColor: 'transparent' }}
                />
                <OutlinedButton
                    onClick={() => handleOpenModal('REGISTRAZIONE')}
                    text="Registrati"
                    section={false}
                />
            </div>
            <div className='sectionTitle' style={{ paddingLeft: "20px" }}>
                <span>Sezioni</span>
                <div className='sectionLine'></div>
            </div>
            <div className='sections'>
                <div className='buttonGroup'>
                    <OutlinedButton
                        onClick={() => alert('Vai al calendario')}
                        text="Calendario"
                        icon={<FaCalendarAlt />}
                        section={true}
                    />
                </div>
                <div className='buttonGroup'>
                    <OutlinedButton
                        onClick={() => alert('Vai al supporto')}
                        text="Supporto"
                        icon={<FaQuestionCircle />}
                        section={true}
                    />
                </div>
            </div>

            <CustomModal
                isOpen={isModalOpen}
                onClose={handleCloseModal}
                content={modalContent}
            />
        </>
    );
};
export default BodyAccesso;