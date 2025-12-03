from fastapi import APIRouter, Depends, HTTPException
from sqlmodel import Session, select
from app.models import Game
from app.schemas import GameCreate, GameUpdate
from app.database import get_session

router = APIRouter(prefix="/games", tags=["Games"])

@router.post("/")
def create_game(game: GameCreate, session: Session = Depends(get_session)):
    db_game = Game(**game.dict(), media_type="game")
    session.add(db_game)
    session.commit()
    session.refresh(db_game)
    return db_game

@router.get("/")
def list_games(session: Session = Depends(get_session)):
    return session.exec(select(Game)).all()

@router.get("/{game_id}")
def get_game(game_id: int, session: Session = Depends(get_session)):
    game = session.get(Game, game_id)
    if not game:
        raise HTTPException(404, "Game not found")
    return game

@router.put("/{game_id}")
def update_game(game_id: int, game_update: GameUpdate, session: Session = Depends(get_session)):
    game = session.get(Game, game_id)
    if not Game: 
        raise HTTPException(status_code=404, detail="Game not found")

    for key, value in game_update.dict(exclude_unset=True).items():
        setattr(game, key, value)

    session.add(game)
    session.commit()
    session.refresh(game)
    return game 

@router.delete("/{game_id}")
def delete_game(game_id: int, session: Session = Depends(get_session)):
    game = session.get(Game, game_id)
    if not game:
        raise HTTPException(404, "Game not found")
    session.delete(game)
    session.commit()
    return {"message": "Deleted"}


