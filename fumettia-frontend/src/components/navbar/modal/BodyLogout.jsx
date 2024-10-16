import React from 'react';
import ModalButton from './ModalButton';
import { FaCalendarAlt, FaBook, FaBookOpen, FaQuestionCircle } from 'react-icons/fa';
import OutlinedButton from './OutlinedButton';
import { useDispatch } from 'react-redux';
import { clearUser } from '../../../store/slice/utenteSlice';

function BodyLogout() {
    const dispatch = useDispatch();

    const onLogout = () => {
        dispatch(clearUser());
    };

    const handleSectionClick = (section) => {
        alert(`Vai a ${section}`);
    };

    return (
        <>
            <ModalButton onClick={onLogout} text="Esci" />
            <div className='sectionTitle' style={{ paddingLeft: "20px" }}>
                <span>Sezioni</span>
                <div className='sectionLine'></div>
            </div>
            <div className='sections'>
                <div className='buttonGroup'>
                    <OutlinedButton
                        onClick={() => handleSectionClick('calendario')}
                        text="Calendario"
                        icon={<FaCalendarAlt />}
                        section={true}
                    />
                    <OutlinedButton
                        onClick={() => handleSectionClick('collezione')}
                        text="Collezione"
                        icon={<FaBook />}
                        section={true}
                    />
                </div>
                <div className='buttonGroup'>
                    <OutlinedButton
                        onClick={() => handleSectionClick('letture')}
                        text="Letture"
                        icon={<FaBookOpen />}
                        section={true}
                    />
                    <OutlinedButton
                        onClick={() => handleSectionClick('supporto')}
                        text="Supporto"
                        icon={<FaQuestionCircle />}
                        section={true}
                    />
                </div>
            </div>
        </>
    );
}

export default BodyLogout;
