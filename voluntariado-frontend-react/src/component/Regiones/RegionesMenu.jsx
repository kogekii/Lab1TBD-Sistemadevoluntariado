import ListGroup from 'react-bootstrap/ListGroup';

function replaceName(name){
    if(!name) return '- Sin Nombre -';
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
                    {(!reg.nom_reg) ? (<em>Sin Nombre</em>) : (<span>{replaceName(reg.nom_reg)}</span>)}
                </ListGroup.Item>
            ))}
        </ListGroup>
    )
}