import React from 'react';
import './widgetSmall.css';
import { VisibilityOutlined } from '@mui/icons-material';

export default function WidgetSmall() {
    return (
        <div className='widgetSmall'>
            <h3 className='widgetSmallTitle'>New Join Members</h3>
            <ul className='widgetSmallList'>
                <li className='widgetSmallListItem'>
                    <img src='https://picsum.photos/seed/picsum/200/300' alt='' className='widgetSmallImg' />
                    <div className='widgetSmallUser'>
                        <span className='widgetSmallUsername'>Anna</span>
                        <span className='widgetSmallUserTitle'>Software Developer</span>
                    </div>
                    <button className='widgetSmallButton'>
                        <VisibilityOutlined className='widgetSmallIcon'/> Display
                    </button>
                </li>
                <li className='widgetSmallListItem'>
                    <img src='https://picsum.photos/seed/picsum/200/300' alt='' className='widgetSmallImg' />
                    <div className='widgetSmallUser'>
                        <span className='widgetSmallUsername'>Anna</span>
                        <span className='widgetSmallUserTitle'>Software Developer</span>
                    </div>
                    <button className='widgetSmallButton'>
                        <VisibilityOutlined className='widgetSmallIcon'/> Display
                    </button>
                </li>
                <li className='widgetSmallListItem'>
                    <img src='https://picsum.photos/seed/picsum/200/300' alt='' className='widgetSmallImg' />
                    <div className='widgetSmallUser'>
                        <span className='widgetSmallUsername'>Anna</span>
                        <span className='widgetSmallUserTitle'>Software Developer</span>
                    </div>
                    <button className='widgetSmallButton'>
                        <VisibilityOutlined className='widgetSmallIcon' /> Display
                    </button>
                </li>
                <li className='widgetSmallListItem'>
                    <img src='https://picsum.photos/seed/picsum/200/300' alt='' className='widgetSmallImg' />
                    <div className='widgetSmallUser'>
                        <span className='widgetSmallUsername'>Anna</span>
                        <span className='widgetSmallUserTitle'>Software Developer</span>
                    </div>
                    <button className='widgetSmallButton'>
                        <VisibilityOutlined className='widgetSmallIcon' /> Display
                    </button>
                </li>
                <li className='widgetSmallListItem'>
                    <img src='https://picsum.photos/seed/picsum/200/300' alt='' className='widgetSmallImg' />
                    <div className='widgetSmallUser'>
                        <span className='widgetSmallUsername'>Anna</span>
                        <span className='widgetSmallUserTitle'>Software Developer</span>
                    </div>
                    <button className='widgetSmallButton'>
                        <VisibilityOutlined className='widgetSmallIcon'/> Display
                    </button>
                </li>
            </ul>
        </div>
    )
}
