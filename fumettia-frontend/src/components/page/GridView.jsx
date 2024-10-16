import React, { useEffect, useState } from 'react';
import GenericModalDettagli from '../../utility/GenericModalDettagli';
import { useDispatch, useSelector } from 'react-redux';
import { selectMangaItems } from '../../store/slice/mangaSlice';
import { initializeMangaItems } from '../../utility/FunzioniThunkManga';

function GridView({data}) {
  const dispatch = useDispatch();
  const items = useSelector(selectMangaItems);
  const [show, setShow] = useState(false);
  const [selectedItem, setSelectedItem] = useState(null);
  const [viewCollection, setViewCollection] = useState(false);
  const [selectedVolumes, setSelectedVolumes] = useState([]);

  useEffect(() => {
    if (items.length === 0) {
      dispatch(initializeMangaItems());
    }
  }, [dispatch, items]);

  const handleClose = () => setShow(false);
  const handleShow = (item) => {
    setSelectedItem(item);
    setShow(true);
  };

  const toggleCollectionView = () => {
    setViewCollection(!viewCollection);
  };

  const handleVolumeSelect = (volume) => {
    if (selectedVolumes.includes(volume)) {
      setSelectedVolumes(selectedVolumes.filter(v => v !== volume));
    } else {
      setSelectedVolumes([...selectedVolumes, volume]);
    }
  };

  return (
    <div className="grid-view">
      {items.map((item, index) => (
        <button className="grid-item" key={index} onClick={() => handleShow(item)}>
          <img src={item.image} alt={item.title} />
          <h5>{item.title}</h5>
        </button>
      ))}

      <GenericModalDettagli 
        show={show} 
        handleClose={handleClose} 
        selectedItem={selectedItem} 
        viewCollection={viewCollection} 
        toggleCollectionView={toggleCollectionView} 
        volumes={items.volumes} 
        selectedVolumes={selectedVolumes} 
        handleVolumeSelect={handleVolumeSelect}
      />
    </div>
  );
}

export default GridView;
