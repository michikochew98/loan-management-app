import React from 'react';
import './widgetLarge.css'

export default function WidgetLarge() {
    const Button = ({type}) => {
        return <button className={`widgetLargeButton ${type}`}>{type}</button>
    }
    return (
        <div className='widgetLarge'>
            <h3 className='widgetLargeTitle'>Latest transaction</h3>
            <table className='widgetLargeTable'>
                <tr className='widgetLargeTr'>
                    <th className='widgetLargeTh'>Customer</th>
                    <th className='widgetLargeTh'>Date</th>
                    <th className='widgetLargeTh'>Amount</th>
                    <th className='widgetLargeTh'>Status</th>
                </tr>
                <tr className='widgetLargeTr'>
                    <td className='widgetLargeUser'>
                        <img src='https://picsum.photos/seed/picsum/200/300' alt='' className='widgetLargeImg' />
                        <span className='widgetLargeName'>Susan</span>
                    </td>
                    <td className='widgetLargeDate'>2 June 2021</td>
                    <td className='widgetLargeAmount'>$121.00</td>
                    <td className='widgetLargeStatus'>
                        <Button type='Pending' />
                    </td>
                </tr>
                <tr className='widgetLargeTr'>
                    <td className='widgetLargeUser'>
                        <img src='https://picsum.photos/seed/picsum/200/300' alt='' className='widgetLargeImg' />
                        <span className='widgetLargeName'>Susan</span>
                    </td>
                    <td className='widgetLargeDate'>2 June 2021</td>
                    <td className='widgetLargeAmount'>$121.00</td>
                    <td className='widgetLargeStatus'>
                        <Button type='Declined' />
                    </td>
                </tr>
                <tr className='widgetLargeTr'>
                    <td className='widgetLargeUser'>
                        <img src='https://picsum.photos/seed/picsum/200/300' alt='' className='widgetLargeImg' />
                        <span className='widgetLargeName'>Susan</span>
                    </td>
                    <td className='widgetLargeDate'>2 June 2021</td>
                    <td className='widgetLargeAmount'>$121.00</td>
                    <td className='widgetLargeStatus'>
                        <Button type='Approved' />
                    </td>
                </tr>
            </table>
        </div>
    )
}
