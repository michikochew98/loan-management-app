import React from 'react';
import Chart from '../../component/chart/Chart';
import FeaturedInfo from '../../component/featuredInfo/FeaturedInfo';
import './home.css';
import { paymentData } from '../../dummyData';
import WidgetSmall from '../../component/widgetSmall/WidgetSmall';
import WidgetLarge from '../../component/widgetLarge/WidgetLarge';

export default function Home() {
    return (
        <div className='home'>
            <FeaturedInfo />
            <Chart
                title='Payment Analytics'
                data={paymentData}
                dataKey='payment'
                grid
            />
            <div className='homeWidgets'>
                <WidgetSmall />
                <WidgetLarge />
            </div>
        </div>
    )
}
