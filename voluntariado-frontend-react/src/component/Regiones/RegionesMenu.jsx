import ListGroup from 'react-bootstrap/ListGroup';

function replaceName(name){
    return name.replace('Región del', 'R.').replace('Región de', 'R.').replace('Región', 'R.').trim();
}

export default function RegionesMenu({ className, regiones, region, loading=true, onChange }){
    if(loading){
        return (<div className="loading">Cargando...</div>);
    }
    return (
        <ListGroup className={className}>
            {regiones.map(reg => (
                <ListGroup.Item
                    key={reg.gid}
                    action
                    active={reg === region}
                    className="menu-text"
                    onClick={() => onChange(reg)}
                >
                    {replaceName(reg.nom_reg)}
                </ListGroup.Item>
            ))}
        </ListGroup>
    )
}