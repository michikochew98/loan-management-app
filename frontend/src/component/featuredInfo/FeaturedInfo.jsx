import React from 'react';
import "./featuredInfo.css";
import { ArrowDownwardOutlined, ArrowUpwardOutlined } from '@mui/icons-material';

export default function FeaturedInfo() {
    return (
        <div className='featured'>
            <div className="featuredItem">
                <span className="featuredTitle">Revenue</span>
                <div className="featuredMoneyContainer">
                    <span className="featuredMoney">$200</span>
                    <span className="featuredMoneyRate">
                        -10 <ArrowDownwardOutlined className="featuredIcon negative"/>
                    </span>
                </div>
                <span className="featuredSubtitle">Compared to last month</span>
            </div>
            <div className="featuredItem">
                <span className="featuredTitle">Clients</span>
                <div className="featuredMoneyContainer">
                    <span className="featuredMoney">$200</span>
                    <span className="featuredMoneyRate">
                        -10 <ArrowDownwardOutlined className="featuredIcon negative"/>
                    </span>
                </div>
                <span className="featuredSubtitle">Compared to last month</span>
            </div>
            <div className="featuredItem">
                <span className="featuredTitle">Pre-approved Client</span>
                <div className="featuredMoneyContainer">
                    <span className="featuredMoney">$200</span>
                    <span className="featuredMoneyRate">
                        10 <ArrowUpwardOutlined className="featuredIcon"/>
                    </span>
                </div>
                <span className="featuredSubtitle">Compared to last month</span>
            </div>
        </div>
    )
}
