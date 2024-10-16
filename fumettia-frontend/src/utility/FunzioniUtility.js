import DanDaDanPhotoExample from '../assets/dandadan.webp';
import SoloLevelingPhotoExample from '../assets/Solo_Leveling.jpg';
import KingInBlackPhotoExample from '../assets/KinginBlack.jpg';

export const generateRandomTitle = () => {
    const length = Math.floor(Math.random() * (10 - 3 + 1)) + 3;
    const characters = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    let result = '';
    
    for (let i = 0; i < length; i++) {
      const randomIndex = Math.floor(Math.random() * characters.length);
      result += characters[randomIndex];
    }
    
    return result.charAt(0).toUpperCase() + result.slice(1);
  };

  export const getRandomColor = () => {
    const letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
      color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
  };

  export const generateMangaItems = () => [
    {
      title: 'DanDaDan',
      image: DanDaDanPhotoExample,
      volumes: Array(5).fill().map((_, index) => ({
        title: `Volume ${index + 1}`,
        image: 'https://via.placeholder.com/100x150',
      })),
    },
    ...Array.from({ length: 4 }, () => ({
      title: `Manga ${Math.floor(Math.random() * 100)}`,
      image: `https://via.placeholder.com/200x300/${Math.floor(Math.random() * 16777215).toString(16)}/FFFFFF?text=Placeholder`,
      volumes: Array(5).fill().map((_, index) => ({
        title: `Volume ${index + 1}`,
        image: 'https://via.placeholder.com/100x150',
      })),
    })),
  ];

  export const generateManhwaItems = () => [
    {
      title: 'Solo Leveling',
      image: SoloLevelingPhotoExample,
      volumes: Array(5).fill().map((_, index) => ({
        title: `Volume ${index + 1}`,
        image: 'https://via.placeholder.com/100x150',
      })),
    },
    ...Array.from({ length: 4 }, () => ({
      title: `Manhwa ${Math.floor(Math.random() * 100)}`,
      image: `https://via.placeholder.com/200x300/${Math.floor(Math.random() * 16777215).toString(16)}/FFFFFF?text=Placeholder`,
      volumes: Array(5).fill().map((_, index) => ({
        title: `Volume ${index + 1}`,
        image: 'https://via.placeholder.com/100x150',
      })),
    })),
  ];

  export const generateComixItems = () => [
    {
      title: 'Spider Man King in black',
      image: KingInBlackPhotoExample,
      volumes: Array(5).fill().map((_, index) => ({
        title: `Volume ${index + 1}`,
        image: 'https://via.placeholder.com/100x150',
      })),
    },
    ...Array.from({ length: 4 }, () => ({
      title: `Comix ${Math.floor(Math.random() * 100)}`,
      image: `https://via.placeholder.com/200x300/${Math.floor(Math.random() * 16777215).toString(16)}/FFFFFF?text=Placeholder`,
      volumes: Array(5).fill().map((_, index) => ({
        title: `Volume ${index + 1}`,
        image: 'https://via.placeholder.com/100x150',
      })),
    })),
  ];