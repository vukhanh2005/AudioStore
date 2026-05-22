import { useNavigate } from 'react-router-dom';
import logoImage from '../assets/logo/logo_2.png'
function Logo() {
    const navigate = useNavigate();
    return ( 
        <div className="logo">
            <img src={logoImage} alt="logo" className="logo-image" onClick={()=>{navigate("/")}}/>
        </div>
     );
}

export default Logo;