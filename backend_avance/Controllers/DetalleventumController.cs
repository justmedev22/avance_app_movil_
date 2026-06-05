using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using backend_avance.Models;

namespace backend_avance.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class DetalleventumController : ControllerBase
    {
        private readonly bdavancetechContext _context;

        public DetalleventumController(bdavancetechContext context)
        {
            _context = context;
        }

        // GET: api/Detalleventum
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Detalleventum>>> GetDetalleventa()
        {
            return await _context.Detalleventa.ToListAsync();
        }

        // GET: api/Detalleventum/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Detalleventum>> GetDetalleventum(int id)
        {
            var detalleventum = await _context.Detalleventa.FindAsync(id);

            if (detalleventum == null)
            {
                return NotFound();
            }

            return detalleventum;
        }

        // PUT: api/Detalleventum/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutDetalleventum(int id, Detalleventum detalleventum)
        {
            if (id != detalleventum.IdDetalleventa)
            {
                return BadRequest();
            }

            _context.Entry(detalleventum).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!DetalleventumExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Detalleventum
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Detalleventum>> PostDetalleventum(Detalleventum detalleventum)
        {
            _context.Detalleventa.Add(detalleventum);
            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (DetalleventumExists(detalleventum.IdDetalleventa))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetDetalleventum", new { id = detalleventum.IdDetalleventa }, detalleventum);
        }

        // DELETE: api/Detalleventum/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteDetalleventum(int id)
        {
            var detalleventum = await _context.Detalleventa.FindAsync(id);
            if (detalleventum == null)
            {
                return NotFound();
            }

            _context.Detalleventa.Remove(detalleventum);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool DetalleventumExists(int id)
        {
            return _context.Detalleventa.Any(e => e.IdDetalleventa == id);
        }
    }
}
