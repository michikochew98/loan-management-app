import React from 'react'
import './navbar.css'
import {
  NotificationsNoneOutlined,
  MailOutlineOutlined
} from '@mui/icons-material';


export default function Navbar() {
  return (
    <div className='navbar'>
      <div className='navbarWrapper'>
        <div className='navbarLeft'><span className='navbarLogo'>MICHIKO</span></div>
        <div className='navbarRight'>
          <div className='navbarIconContainer'>
            <NotificationsNoneOutlined />
            <span className='navbarIconBadge'>2</span>
          </div>
          <div className='navbarIconContainer'>
            <MailOutlineOutlined />
            <span className='navbarIconBadge'>2</span>
          </div>
          <img src='https://picsum.photos/id/22/200/300' alt='' className='navbarAvatar' />
        </div>
      </div>
    </div>
  )
}
