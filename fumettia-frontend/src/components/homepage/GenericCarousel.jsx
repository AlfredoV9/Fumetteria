import React, { useState, useEffect } from 'react';
import GenericModalDettagli from '../../utility/GenericModalDettagli';
import { useGetVolumiPerFumettoQuery } from '../../api/VolumeApi';

function GenericCarousel({ title, data, carouselId }) {
  const [show, setShow] = useState(false);
  const [selectedItem, setSelectedItem] = useState(null);
  const [viewCollection, setViewCollection] = useState(false);
  const [selectedVolumes, setSelectedVolumes] = useState([]);
  const [titleItemSelected, setTitleItemSelected] = useState('');

  const { data: volumes, isFetching, isError } = useGetVolumiPerFumettoQuery(
    { titolo: titleItemSelected },
    { skip: titleItemSelected === '' }
  );

  useEffect(() => {
    if (selectedItem) setShow(true);
  }, [selectedItem]);

  const handleVolumeSelect = (volume) => {
    if (selectedVolumes.includes(volume)) {
      setSelectedVolumes(selectedVolumes.filter((v) => v !== volume));
    } else {
      setSelectedVolumes([...selectedVolumes, volume]);
    }
  };

  const handleShow = (item) => {
    const selectedItemData = {
      fumetto: item?.fumetto ? item.fumetto : item,
      image: item?.fumetto?.image 
        ? item.fumetto.image 
        : item?.image 
          ? item.image 
          : 'https://via.placeholder.com/150/FF0000/FFFFFF?text=Red'
    };

    setSelectedItem(selectedItemData);
    setTitleItemSelected(item.fumetto.titolo);
  };

  const handleClose = () => {
    setShow(false);
    setSelectedItem(null);
  };

  const toggleCollectionView = () => {
    setViewCollection(!viewCollection);
  };

  return (
    <div className="carousel-container">
      <h2 className="text-center text-purple">{title}</h2>
      <div id={`carousel-${carouselId}`} className="carousel slide" data-bs-ride="carousel">
        <div className="carousel-inner">
          {Array.isArray(data) && data.length > 0 ? (
            data.map((item, index) => (
              <div key={index} className={`carousel-item ${index === 0 ? 'active' : ''}`} onClick={() => handleShow(item)} style={{ cursor: 'pointer' }}>
                <div className="carousel-content">
                  <img
                    src={item?.fumetto?.image || item?.image || 'https://via.placeholder.com/150/FF0000/FFFFFF?text=Red'}
                    className="d-block w-100 carousel-img"
                    alt={item?.fumetto?.titolo || item?.titolo || 'Default Image'}
                  />
                  <div className="carousel-caption d-none d-md-block">
                    <h5>
                      {item?.fumetto?.titolo || item?.titolo}
                      {item?.numero ? ` ${item.numero}` : ''}
                    </h5>
                    <small>Data di uscita: {item?.dataRilascio || 'N/A'}</small>
                  </div>
                </div>
              </div>
            ))
          ) : (
            <div className="carousel-item active">
              <div className="carousel-content">
                <h5 className="error-content">{data?.data || 'Nessun dato disponibile'}</h5>
              </div>
            </div>
          )}
        </div>

        <button className="carousel-control-prev" type="button" data-bs-target={`#carousel-${carouselId}`} data-bs-slide="prev">
          <span className="carousel-control-prev-icon" aria-hidden="true"></span>
          <span className="visually-hidden">Precedente</span>
        </button>
        <button className="carousel-control-next" type="button" data-bs-target={`#carousel-${carouselId}`} data-bs-slide="next">
          <span className="carousel-control-next-icon" aria-hidden="true"></span>
          <span className="visually-hidden">Successivo</span>
        </button>
      </div>

      <GenericModalDettagli
        show={show}
        handleClose={handleClose}
        selectedItem={selectedItem}
        viewCollection={viewCollection}
        toggleCollectionView={toggleCollectionView}
        volumes={volumes || []}
        selectedVolumes={volumes}
        handleVolumeSelect={handleVolumeSelect}
      />

      {isFetching && <p>Loading volumes...</p>}
      {isError && <p>Errore nel recupero dei volumi.</p>}
    </div>
  );
}

export default GenericCarousel;
