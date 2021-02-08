export interface Station {
    
    borne_disponible: number;
    borne_en_station: number;
    code_tation: number;
    nom_station: string;
    velo_electrique: number;
    velo_mecanique: number;
    lat :number;
    longe:number;
    paymentcb:string;
    //  records : Array<{ 
    //      fields: { 
    //          capacity : number;
    //           name : string;
    //            lon : number;
    //             station_id : number; 
    //             stationcode : number;
    //              lat :number
    //          };
    // }>; 
}