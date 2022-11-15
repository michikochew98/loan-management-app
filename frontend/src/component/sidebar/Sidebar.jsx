import React from 'react'
import './sidebar.css'
import {
    DashboardOutlined,
    ArticleOutlined,
    InsertChartOutlined,
    GroupOutlined,
    IntegrationInstructionsOutlined,
    FlagOutlined,
    PaidOutlined,
    Settings
} from '@mui/icons-material';
import { Link } from 'react-router-dom';

export default function Sidebar() {
    return (
        <div className='sidebar'>
            <div className='sidebarWrapper'>
                <div className='sidebarMenu'>
                    <h3 className='sidebarTitle'>Dashboard</h3>
                    <ul className='sidebarList'>
                        <li className='sidebarItem active'>
                            <DashboardOutlined className='icon' /> Dashboard
                        </li>
                        <Link to="/products" className='link'>
                            <li className='sidebarItem'>
                                <ArticleOutlined className='icon' /> Templates
                            </li>
                        </Link>
                        <li className='sidebarItem'>
                            <InsertChartOutlined className='icon' /> Loan Graph
                        </li>
                        <Link to="/users" className='link'>
                            <li className='sidebarItem'>
                                <GroupOutlined className='icon' /> Partners
                            </li>
                        </Link>
                    </ul>
                </div>
                <div className='sidebarMenu'>
                    <h3 className='sidebarTitle'>Tools</h3>
                    <ul className='sidebarList'>
                        <li className='sidebarItem'>
                            <IntegrationInstructionsOutlined className='icon' /> Integrations
                        </li>
                        <li className='sidebarItem'>
                            <FlagOutlined className='icon' /> Reports
                        </li>
                    </ul>
                </div>
                <div className='sidebarMenu'>
                    <h3 className='sidebarTitle'>Others</h3>
                    <ul className='sidebarList'>
                        <li className='sidebarItem'>
                            <PaidOutlined className='sidebarIcon' /> Plans & Fee
                        </li>
                        <li className='sidebarItem'>
                            <Settings className='sidebarIcon' /> Settings
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    )
}
