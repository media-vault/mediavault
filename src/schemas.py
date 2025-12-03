from typing import Optional
from pydantic import BaseModel

class MediaCreate(BaseModel):
    title: str
    description: Optional[str] = None
    year: Optional[int] = None
    poster_url: Optional[str] = None
    media_type: str

class MovieCreate(MediaCreate):
    director: Optional[str] = None

class TVShowCreate(MediaCreate):
    seasons: Optional[str] = None

class GameCreate(MediaCreate):
    platform: Optional[str] = None

class MediaUpdate(BaseModel):
    title: str
    description: Optional[str] = None
    year: Optional[int] = None
    poster_url: Optional[str] = None

class MovieUpdate(MediaUpdate):
    director: Optional[str] = None

class TVShowUpdate(MediaUpdate):
    seasons: Optional[str] = None

class GameUpdate(MediaUpdate):
    platform: Optional[str] = None

