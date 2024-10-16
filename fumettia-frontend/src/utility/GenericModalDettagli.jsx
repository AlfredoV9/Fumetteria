import React, { useState } from 'react';
import { Modal, Button } from 'react-bootstrap';
import { useDispatch } from 'react-redux';
import { addVolumesToCollection } from '../store/slice/volumeSlice';
import { FaArrowLeft } from 'react-icons/fa';
import ModalButton from '../components/navbar/modal/ModalButton';
import '../styles/FumettoModal.css';

const GenericModalDettagli = ({
    show,
    handleClose,
    selectedItem,
    viewCollection,
    toggleCollectionView,
    volumes,
    selectedVolumes,
    handleVolumeSelect
}) => {
    const dispatch = useDispatch();
    const [showVolumes, setShowVolumes] = useState(false);

    const saveSelectedVolumes = () => {
        const selected = volumes
            .filter(volume => selectedVolumes.includes(volume.number))
            .map(volume => ({ title: selectedItem.title, number: volume.number }));
        
        console.log('Selected Volumes to save:', selected); // Stampa i volumi selezionati
        dispatch(addVolumesToCollection(selected));
        handleClose();
    };

    const handleAddToCollection = () => {
        setShowVolumes(true);
        console.log('Add to collection clicked'); // Stampa quando si clicca per aggiungere alla collezione
    };

    const handleDettagli = () => {
        setShowVolumes(false);
        console.log('Detail view closed'); // Stampa quando si chiude la vista dettagli
    };

    const handleVolumeSelectWrapper = (volumeNumber) => {
        handleVolumeSelect(volumeNumber);
        console.log(`Volume ${volumeNumber} selected`); // Stampa il volume selezionato
    };

    return (
        <Modal show={show} onHide={handleClose} centered
            style={{
                width: showVolumes ? '75vw' : '60vw',
                maxWidth: showVolumes ? '75vw' : '60vw',
                right: '0px',
                marginLeft: showVolumes ? '12.5vw' : '20vw',
                marginRight: showVolumes ? '12.5vw' : '20vw',
                overflowY: 'auto',
                scrollbarWidth: 'none'
            }}>
            <div className="modal-background" style={{
                backgroundImage: selectedItem ? `url(${selectedItem.image})` : '',
                backgroundSize: 'cover',
                backgroundPosition: 'center',
                filter: 'blur(8px)',
                position: 'absolute',
                top: 0,
                left: 0,
                width: '100%',
                height: '100%',
            }} />

            {!showVolumes ? (
                <Modal.Body className="modal-body">
                    <div style={{ display: 'flex', alignItems: 'center' }}>
                        <img src={selectedItem ? selectedItem.image : ''} alt={selectedItem ? selectedItem.fumetto.titolo : ''} />
                        <div style={{ marginLeft: '20px' }}>
                            <h5>{selectedItem ? selectedItem.fumetto.titolo : ''}</h5>
                            <div className="button-container">
                                <Button variant="primary" style={{ marginRight: '10px' }}>Segui</Button>
                                <Button variant="success" style={{ marginRight: '10px' }}>Acquista</Button>
                                <Button variant="warning" onClick={toggleCollectionView}>
                                    {viewCollection ? 'Inizia Lettura' : 'Continua Lettura'}
                                </Button>
                            </div>
                        </div>
                    </div>
                    <div className="button-container">
                        <ModalButton onClick={handleAddToCollection} text='Inserisci in Collezione' />
                    </div>
                </Modal.Body>
            ) : (
                <Modal.Body className="modal-body">
                    <div style={{ display: 'flex', flexDirection: 'row', alignItems: 'baseline' }}>
                        <Button variant="secondary" onClick={handleDettagli} style={{ border: '0px', background: 'transparent', display: 'flex', alignItems: 'center' }}>
                            <FaArrowLeft style={{ marginRight: '5px' }} />
                        </Button>
                        <h5 style={{ marginLeft: '10px' }}>{selectedItem ? selectedItem.title : ''}</h5>
                    </div>
                    <h2>Seleziona i volumi che possiedi</h2>
                    <div className="volume-selection">
                        {volumes.map((volume, index) => (
                            <div
                                key={index}
                                className={`volume-card ${selectedVolumes.includes(volume.number) ? 'selected' : ''}`}
                                onClick={() => handleVolumeSelectWrapper(volume.number)}
                            >
                                {selectedVolumes.includes(volume.numero) && (
                                    <div className="checkmark">✔</div>
                                )}
                                <img src={volume.image || selectedItem.image } alt={volume.numero} style={{ width: '100px', height: '150px' }} />
                                <p style={{ textAlign: 'center', marginTop: '5px' }}>{selectedItem.fumetto.titolo} {volume.numero}</p>
                            </div>
                        ))}
                    </div>
                    <div style={{ display: 'flex', justifyContent: 'center' }}>
                        <ModalButton onClick={saveSelectedVolumes} text='Salva Volumi Selezionati' />
                    </div>
                </Modal.Body>
            )}
        </Modal>
    );
};

export default GenericModalDettagli;
